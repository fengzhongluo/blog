<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<jsp:include page="common.jsp"></jsp:include>

<body data-type="widgets">
    <script src="admin/assets/js/theme.js"></script>
    <div class="am-g tpl-g">
		<jsp:include page="head.jsp"></jsp:include>
        <!-- 风格切换 -->
        <div class="tpl-skiner">
            <div class="tpl-skiner-toggle am-icon-cog">
            </div>
            <div class="tpl-skiner-content">
                <div class="tpl-skiner-content-title">
                   	 选择主题
                </div>
                <div class="tpl-skiner-content-bar">
                    <span class="skiner-color skiner-white" data-color="theme-white"></span>
                    <span class="skiner-color skiner-black" data-color="theme-black"></span>
                </div>
            </div>
        </div>
        <jsp:include page="left_navigate.jsp" ></jsp:include>

        <!-- 内容区域 -->
        <div class="tpl-content-wrapper">

            
            <div class="row-content am-cf">

                <div class="row">

                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title am-fl">边框表单</div>
                                <div class="widget-function am-fr">
                                    <a href="javascript:;" class="am-icon-cog"></a>
                                </div>
                            </div>
                            <div class="widget-body am-fr">

                                <form class="am-form tpl-form-border-form tpl-form-border-br" action="http://127.0.0.1:8080/blog/admin?to=edit" method="post">
                                	<input type="hidden" name="id" value="${article.id }">
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">标题 <span class="tpl-form-line-small-title">Title</span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" class="tpl-form-input" id="user-name" placeholder="请输入标题文字" name="title" value="${article.title }" required>
                                            <small>请填写标题文字10-20字左右。</small>
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-email" class="am-u-sm-3 am-form-label">发布时间 <span class="tpl-form-line-small-title">Time</span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" class="am-form-field tpl-form-no-bg" placeholder="发布时间" data-am-datepicker="" readonly="" name="publishTime" value="${article.publishTime }"  placeholder="时间必填" required>
                                            <small>发布时间为必填</small>
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-phone" class="am-u-sm-3 am-form-label">作者 <span class="tpl-form-line-small-title">Author</span></label>
                                        <div class="am-u-sm-9">
                                            <select data-am-selected="{searchBox: 1}" style="display: none;"  name="author" value="${article.author }" >
											  <option value="a">-The.CC</option>
											  <option value="b">夕风色</option>
											  <option value="o">Orange</option>
											</select>

                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label class="am-u-sm-3 am-form-label">SEO关键字 <span class="tpl-form-line-small-title">SEO</span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text"   placeholder="输入SEO关键字">
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-weibo" class="am-u-sm-3 am-form-label">封面图 <span class="tpl-form-line-small-title">Images</span></label>
                                        <div class="am-u-sm-9">
                                            <div class="am-form-group am-form-file">
                                                <div class="tpl-form-file-img">
                                                    <img id="imgPre" src="admin/assets/img/a5.png" alt="">
                                                </div>
                                                <button type="button" class="am-btn am-btn-danger am-btn-sm">
    												<i  class="am-icon-cloud-upload"></i> 添加封面图片
                                                </button>
                                                <input id="doc-form-file" type="file" multiple="" name="file" accept="image/*" onchange="preImg(this.id,'imgPre');">
                                            </div>

                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-weibo" class="am-u-sm-3 am-form-label">添加分类 <span class="tpl-form-line-small-title">Type</span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" id="user-weibo" placeholder="请添加分类用点号隔开" name="tags">
                                            <div>

                                            </div>
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-intro" class="am-u-sm-3 am-form-label">隐藏文章</label>
                                        <div class="am-u-sm-9">
                                            <div class="tpl-switch">
                                                <input type="checkbox" class="ios-switch bigswitch tpl-switch-btn" checked="">
                                                <div class="tpl-switch-btn-view">
                                                    <div>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    
									<div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">摘要 <span class="tpl-form-line-small-title">summary</span></label>
                                        <div class="am-u-sm-9">
                                            <textarea rows="5" id="user-intro" placeholder="请输入标题文字" name="summary"  >${article.summary}</textarea>
                                            <small>请填写标题文字10-20字左右。</small>
                                        </div>
                                    </div>
                                    
                                    <div class="am-form-group">
                                        <label for="user-intro" class="am-u-sm-3 am-form-label">文章内容</label>
                                        <div class="am-u-sm-9" >
											<!-- <textarea class="am-validate" name="html" id="editor" placeholder="请输入标题"   required ></textarea> -->
                                            <script type="text/plain" id="editor" name="html"  placeholder="请输入标题"   required>${article.html}</script>
                                            
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <div class="am-u-sm-9 am-u-sm-push-3">
                                            <button type="submit" class="am-btn am-btn-primary tpl-btn-bg-color-success">提交</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>
    </div>
    <script src="admin/assets/js/amazeui.min.js"></script>
    <script src="admin/assets/js/amazeui.datatables.min.js"></script>
    <script src="admin/assets/js/dataTables.responsive.min.js"></script>
    <script src="admin/assets/js/app.js"></script>
	<!-- UEditor -->
	<script type="text/javascript" charset="utf-8" src="UEditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="UEditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="UEditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript">
    	var ue = UE.getEditor('editor').hasContents();
    	
    	function getFileUrl(sourceId) {   
            var url;   
            if (navigator.userAgent.indexOf("MSIE")>=1) { // IE   
            url = document.getElementById(sourceId).value;   
        }   
            else if(navigator.userAgent.indexOf("Firefox")>0) { // Firefox   
            url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));   
        }   
            else if(navigator.userAgent.indexOf("Chrome")>0) { // Chrome   
            url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));   
        }   
            return url;   
        }  
        function preImg(sourceId, targetId) {   
            var url = getFileUrl(sourceId);   
            var imgPre = document.getElementById(targetId);   
            imgPre.src = url;   
        }   

    	
    	
    	var uploading = false;
    	function fileChange(){
    		var img="<img src='"+$("#doc-form-file").val()+"' alt=''>";
    		$(".tpl-form-file-img").html(img);
    		
    	}
    	function fileChange1(){
    	    $("#fileTypeError").html('');
    	    var fileName = $('#doc-form-file').val();								//获得文件名称
    	    var fileType = fileName.substr(fileName.length-4,fileName.length);	//截取文件类型,如(.xls)
    	    if(fileType=='.jpg' || fileType=='.doc' || fileType=='.pdf'){	//验证文件类型,此处验证也可使用正则
    	        $.ajax({
    	            url: 'http://127.0.0.1:8080/blog/uploadfile',		　//上传地址
    	            type: 'POST',
    	            cache: false,　　
    	            data: new FormData($('#uploadForm')[0]),　　　　　　　　　　　　　//表单数据
    	            processData: false,
    	            contentType: false,
    	            success:function(data){
    	                if(data=='fileTypeError'){
    	                    $("#fileTypeError").html('*上传文件类型错误,支持类型: .xsl .doc .pdf');　　//根据后端返回值,回显错误信息
    	                }
    	                $("input[name='enclosureCode']").attr('value',data);
    	            }
    	        });
    	    }else{
    	        $("#fileTypeError").html('*上传文件类型错误,支持类型: .xls .doc .pdf');
    	    }
    	}
    	//var html=ue.getContent();
    </script>
</body>

</html>