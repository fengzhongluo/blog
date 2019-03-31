/**
 * 
 */

var ue = UE.getEditor('editor').hasContents();
function getFileUrl(sourceId) {
	var url;
	if (navigator.userAgent.indexOf("MSIE") >= 1) { // IE   
		url = document.getElementById(sourceId).value;
	} else if (navigator.userAgent.indexOf("Firefox") > 0) { // Firefox   
		url = window.URL
				.createObjectURL(document.getElementById(sourceId).files
						.item(0));
	} else if (navigator.userAgent.indexOf("Chrome") > 0) { // Chrome   
		url = window.URL
				.createObjectURL(document.getElementById(sourceId).files
						.item(0));
	}
	return url;
}
function preImg(sourceId, targetId) {
	var url = getFileUrl(sourceId);
	var imgPre = document.getElementById(targetId);
	var fileName = $('#doc-form-file').val(); //获得文件名称
	var fileType = fileName.substr(fileName.length - 4, fileName.length); //截取文件类型,如(.xls)
	if (fileType == '.jpg' || fileType == '.doc' || fileType == '.pdf') { //验证文件类型,此处验证也可使用正则
		$.ajax({
			url : '/back/uploadfile',//上传地址
			type : 'POST',
			cache : false,
			data : new FormData(document.getElementById("formdata")),//表单数据,必须用js原生的方式获取form表单
			processData : false,
			contentType : false,
			success : function(data) {
				var file = data;
				imgPre.src = url;
				document.getElementById("coverUrl").value = file;
			}
		});
	} else {
		$("#fileTypeError").html('*上传文件类型错误,支持类型: .xls .doc .pdf');
	}

}
