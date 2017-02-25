<%--
  Created by IntelliJ IDEA.
  User: dannyhoo
  Date: 17/2/24
  Time: 上午12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frame/frame-resource-begin.jsp" %>

<div class="am-g tpl-g">

    <!-- 头部 -->
    <%@ include file="../frame/frame-header.jsp" %>

    <!-- 风格切换 -->
    <%@ include file="../frame/frame-skiner.jsp" %>

    <!-- 侧边导航栏 -->
    <%@ include file="../frame/frame-leftsidebar.jsp" %>

    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title  am-cf">文章列表</div>
                        </div>

                        <div class="widget-body  am-fr">
                            <%--编辑按钮--%>
                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                                <div class="am-form-group">
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <button type="button" class="am-btn am-btn-default am-btn-success"><span
                                                    class="am-icon-plus"></span> 新增
                                            </button>
                                            <button type="button" class="am-btn am-btn-default am-btn-secondary"><span
                                                    class="am-icon-save"></span> 保存
                                            </button>
                                            <button type="button" class="am-btn am-btn-default am-btn-warning"><span
                                                    class="am-icon-archive"></span> 审核
                                            </button>
                                            <button type="button" class="am-btn am-btn-default am-btn-danger"><span
                                                    class="am-icon-trash-o"></span> 删除
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%--下拉框--%>
                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                                <div class="am-form-group tpl-table-list-select">
                                    <select data-am-selected="{btnSize: 'sm'}">
                                        <option value="option1">所有类别</option>
                                        <option value="option2">IT业界</option>
                                        <option value="option3">数码产品</option>
                                        <option value="option3">笔记本电脑</option>
                                        <option value="option3">平板电脑</option>
                                        <option value="option3">只能手机</option>
                                        <option value="option3">超极本</option>
                                    </select>
                                </div>
                            </div>
                            <%--搜索框--%>
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                    <input type="text" class="am-form-field ">
                                    <span class="am-input-group-btn">
            <button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search"
                    type="button"></button>
          </span>
                                </div>
                            </div>
                            <%--表格头--%>
                            <div class="am-u-sm-12">
                                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black "
                                       id="example-r">
                                    <%--表格头--%>
                                    <thead>
                                    <tr>
                                        <th>文章标题</th>
                                        <th>作者</th>
                                        <th>时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <%--表格内容--%>
                                    <tbody>
                                    <c:forEach items="${userList}" var="user">
                                        <tr class="gradeX">
                                            <td>${user.userName}</td>
                                            <td>${user.realName}</td>
                                            <td>${user.birthday}</td>
                                            <td>
                                                <div class="tpl-table-black-operation">
                                                    <a href="javascript:;">
                                                        <i class="am-icon-pencil"></i> 编辑
                                                    </a>
                                                    <a href="javascript:;" class="tpl-table-black-operation-del">
                                                        <i class="am-icon-trash"></i> 删除
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <%--<tr class="even gradeC">
                                        <td>有适配微信小程序的计划吗</td>
                                        <td>天纵之人</td>
                                        <td>2016-09-26</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;">
                                                    <i class="am-icon-pencil"></i> 编辑
                                                </a>
                                                <a href="javascript:;" class="tpl-table-black-operation-del">
                                                    <i class="am-icon-trash"></i> 删除
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="gradeX">
                                        <td>请问有没有amazeui 分享插件</td>
                                        <td>王宽师</td>
                                        <td>2016-09-26</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;">
                                                    <i class="am-icon-pencil"></i> 编辑
                                                </a>
                                                <a href="javascript:;" class="tpl-table-black-operation-del">
                                                    <i class="am-icon-trash"></i> 删除
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="even gradeC">
                                        <td>关于input输入框的问题</td>
                                        <td>着迷</td>
                                        <td>2016-09-26</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;">
                                                    <i class="am-icon-pencil"></i> 编辑
                                                </a>
                                                <a href="javascript:;" class="tpl-table-black-operation-del">
                                                    <i class="am-icon-trash"></i> 删除
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="even gradeC">
                                        <td>有没有发现官网上的下载包不好用</td>
                                        <td>醉里挑灯看键</td>
                                        <td>2016-09-26</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;">
                                                    <i class="am-icon-pencil"></i> 编辑
                                                </a>
                                                <a href="javascript:;" class="tpl-table-black-operation-del">
                                                    <i class="am-icon-trash"></i> 删除
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="even gradeC">
                                        <td>我建议WEB版本文件引入问题</td>
                                        <td>罢了</td>
                                        <td>2016-09-26</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;">
                                                    <i class="am-icon-pencil"></i> 编辑
                                                </a>
                                                <a href="javascript:;" class="tpl-table-black-operation-del">
                                                    <i class="am-icon-trash"></i> 删除
                                                </a>
                                            </div>
                                        </td>
                                    </tr>--%>
                                    <!-- more data -->
                                    </tbody>
                                </table>
                            </div>
                            <%--表格内容--%>
                            <div class="am-u-lg-12 am-cf">
                                <div class="am-fr">
                                    <ul class="am-pagination tpl-pagination">
                                        <li class="am-disabled"><a href="#">«</a></li>
                                        <li class="am-active"><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                        <li><a href="#">»</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<%@ include file="../frame/frame-resource-end.jsp" %>


