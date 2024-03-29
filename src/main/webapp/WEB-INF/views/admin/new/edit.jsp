<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="newURL" value="/quan-tri/bai-viet/danh-sach" />
<c:url var="newAPI" value="/api/new" />
<c:url var="editNewURL" value="/quan-tri/bai-viet/chinh-sua" />
<html>
<head>
<title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
	<div class="main-content-inner">
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try {
					ace.settings.check('breadcrumbs', 'fixed')
				} catch (e) {
				}
			</script>

			<ul class="breadcrumb">
				<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
				</li>

				<li><a href="#">Forms</a></li>
				<li class="active">Form Elements</li>
			</ul>
			<!-- /.breadcrumb -->
		</div>
		<div class="page-content">
			<div class="row">
				<div class="col-xs-12">
					<c:if test="${not empty message}">
						<div class="alert alert-${alert}">
  							${message}
						</div>
					</c:if>
					<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
						<div class="form-group">
						  <label class="col-sm-3 control-label no-padding-right" for="categoryCode">the loai:</label>
						  <div class="col-sm-9">
							  <form:select path="categoryCode" id="categoryCode">
							  	<form:option value="" label="chon the loai"/>
							  	<form:options items="${categories}"/>
							  </form:select>
						  </div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-1"> Ten bai viet </label>

							<div class="col-sm-9">
								<form:input path="title" cssClass="col-xs-10 col-sm-5"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-1"> Anh dai dien </label>

							<div class="col-sm-9">
								<input type="file" id="thumbnail" name="thumbnail" 
									class="col-xs-10 col-sm-5" />
							</div>
						</div>
						<div class="form-group">
						  <label class="col-sm-3 control-label no-padding-right" for="shortDescription">Mo ta ngan</label>
						  <div class="col-sm-9">
						  	<form:textarea path="shortDescription" rows="5" cols="10" cssClass="form-control" id="shortDescription"/>
						  </div>
						</div>
						<div class="form-group">
						  <label class="col-sm-3 control-label no-padding-right" for="content">noi dung</label>
						  <div class="col-sm-9">
						  	<form:textarea path="content" rows="5" cols="10" cssClass="form-control" id="content"/>
						  </div>
						  
						</div>
						<form:hidden path="id" id="newId"/>
						<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<c:if test="${not empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													cap nhat bai viet
												</button>
											</c:if>
											<c:if test="${empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													them bai viet
												</button>
											</c:if>
											

											&nbsp; &nbsp; &nbsp;
											<button class="btn" type="reset">
												<i class="ace-icon fa fa-undo bigger-110"></i>
												huy
											</button>
										</div>
									</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	$('#btnAddOrUpdateNew').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
	    var id = $('#newId').val();
	    if(id == ""){
	    	addNew(data);
	    }else{
	    	updateNew(data);
	    }
	});
	function addNew(data){
		$.ajax({
            url: '${newAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editNewURL}?id="+result.id+"&message=insert_success";
            },
            error: function (error) {
            	window.location.href = "${newURL}?page=1&limit=2&message=error_system";
            }
        });
	}
	
	function updateNew(data){
		$.ajax({
            url: '${newAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editNewURL}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${editNewURL}?id="+result.id+"&message=error_system";
            }
        });
	}
</script>
</body>
</html>
