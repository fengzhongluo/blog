<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<jsp:include page="common.jsp"></jsp:include>

<body data-type="widgets">
	<div class="am-g tpl-g">
		<jsp:include page="head.jsp"></jsp:include>
		<!-- 风格切换 -->
		<div class="tpl-skiner">
			<div class="tpl-skiner-toggle am-icon-cog"></div>
			<div class="tpl-skiner-content">
				<div class="tpl-skiner-content-title">选择主题</div>
				<div class="tpl-skiner-content-bar">
					<span class="skiner-color skiner-white" data-color="theme-white"></span>
					<span class="skiner-color skiner-black" data-color="theme-black"></span>
				</div>
			</div>
		</div>
		<jsp:include page="left_navigate.jsp"></jsp:include>

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

								<form id="formdata"
									class="am-form tpl-form-border-form tpl-form-border-br"
									action="http://<%=request.getServerName() %>:<%=request.getServerPort() %>/back/index?to=add"
									method="post">
									<div class="am-form-group">
										<label for="user-name" class="am-u-sm-3 am-form-label">标题
											<span class="tpl-form-line-small-title">Title</span>
										</label>
										<div class="am-u-sm-9">
											<input type="text" class="tpl-form-input" id="user-name"
												placeholder="请输入标题文字" name="title" required> <small>请填写标题文字10-20字左右。</small>
										</div>
									</div>

									<div class="am-form-group">
										<label for="user-weibo" class="am-u-sm-3 am-form-label">封面图
											<span class="tpl-form-line-small-title">Images</span>
										</label>
										<div class="am-u-sm-9">
											<div class="am-form-group am-form-file">
												<div class="tpl-form-file-img">
													<img id="imgPre" src="/admin/assets/img/a5.png" alt="">
												</div>
												<button type="button" class="am-btn am-btn-danger am-btn-sm">
													<i class="am-icon-cloud-upload"></i> 添加封面图片
												</button>
												<input id="doc-form-file" type="file" multiple=""
													name="file" accept="image/*"
													onchange="preImg(this.id,'imgPre');"> <input
													id="coverUrl" type="hidden" name="coverUrl">
											</div>

										</div>
									</div>

									<div class="am-form-group">
										<label for="user-intro" class="am-u-sm-3 am-form-label">隐藏文章</label>
										<div class="am-u-sm-9">
											<div class="tpl-switch">
												<input type="checkbox"
													class="ios-switch bigswitch tpl-switch-btn" checked="">
												<div class="tpl-switch-btn-view">
													<div></div>
												</div>
											</div>

										</div>
									</div>

									<div class="am-form-group">
										<label for="user-name" class="am-u-sm-3 am-form-label">摘要
											<span class="tpl-form-line-small-title">summary</span>
										</label>
										<div class="am-u-sm-9">
											<textarea rows="5" id="user-intro" placeholder="请输入标题文字"
												name="summary"></textarea>
											<small>请填写标题文字10-20字左右。</small>
										</div>
									</div>

									<div class="am-form-group">
										<label for="user-intro" class="am-u-sm-3 am-form-label">文章内容</label>
										<div class="am-u-sm-9">
											<textarea class="am-validate" name="html" id="editor"
												placeholder="请输入标题" required></textarea>

										</div>
									</div>

									<div class="am-form-group">
										<label for="user-weibo" class="am-u-sm-3 am-form-label">标签
											<span class="tpl-form-line-small-title">Type</span>
										</label>
										<div class="am-u-sm-9">
											<input type="text" id="user-weibo" placeholder="请添加分类用点号隔开"
												name="tags">
											<div></div>
										</div>
									</div>
									<div class="am-form-group">
										<label for="user-phone" class="am-u-sm-3 am-form-label">分类
											<span class="tpl-form-line-small-title">Author</span>
										</label>
										<div class="am-u-sm-9">
											<select data-am-selected="{searchBox: 1}"
												style="display: none;">
												<option value="a">-The.CC</option>
												<option value="b">夕风色</option>
												<option value="o">Orange</option>
											</select>
										</div>
									</div>
									<div class="am-form-group">
										<div class="am-u-sm-9 am-u-sm-push-3">
											<button type="submit"
												class="am-btn am-btn-primary tpl-btn-bg-color-success">提交</button>
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

</body>

</html>