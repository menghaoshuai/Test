<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"
	language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">-->
<!-- saved from url=(0022)http://www.aratek.com.cn -->
<!--<html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns="http://www.w3.org/TR/REC-html40">-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CID7000id Test</title>
</head>
<script language="javascript">
	function clearForm() {
		document.all['Name'].value = '';
		document.all['Sex'].value = '';
		document.all['Nation'].value = '';
		document.all['Born'].value = '';
		document.all['Address'].value = '';
		document.all['CardNo'].value = '';
		document.all['Police'].value = '';
		document.all['ActivityLFrom'].value = '';
		document.all['ActivityLTo'].value = '';
		document.all['FPInfo'].value = '';
		document.getElementById("imgPre").src = '';
	}

	function isIE() { //ie?
		if (!!window.ActiveXObject || "ActiveXObject" in window)
			return true;
		else
			return false;
	}

	function strlen(str) {
		var len = 0;
		for (var i = 0; i < str.length; i++) {
			var c = str.charCodeAt(i);
			//单字节加1 
			if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) {
				len++;
			} else {
				len += 2;
			}
		}
		return len;
	}

	function Connect() {//连接设备
		clearForm();
		var resultFlag;
		if (isIE()) {
			resultFlag = CertCtl.CID_IDCARD_OpenDevice();//连接设备
		} else {
			document.getElementById('pluginobj').focus();
			resultFlag = pluginobj.CID_IDCARD_OpenDevice();//连接设备
		}
		if (resultFlag == "0") {
			document.all['conResult'].value = "连接设备成功";
			window.setInterval(Readcert, 3000);
		} else {
			alert(resultFlag);
		}

	}

	function Disconnect() { //断开设备
		clearForm();
		var resultFlag;
		if (isIE()) {
			resultFlag = CertCtl.CID_IDCARD_CloseDevice();//断开设备
		} else {
			document.getElementById('pluginobj').focus();
			resultFlag = pluginobj.CID_IDCARD_CloseDevice();//断开设备
		}
		if (resultFlag == "0") {
			document.all['conResult'].value = "断开设备成功";
		} else {
			alert(resultFlag);
		}

	}

	function Readcert() {//读取身份证
		clearForm();
		var infoStr;
		if (isIE()) {
			infoStr = CertCtl.CID_IDCARD_ReadInfo();//读取身份证
		} else {
			infoStr = pluginobj.CID_IDCARD_ReadInfo();//读取身份证
		}
		if (strlen(infoStr) > 5) {
			var name;
			var id;
			if (isIE()) {
				name = CertCtl.CID_IDCARD_GetName(infoStr);
				id = CertCtl.CID_IDCARD_GetIDNum(infoStr);
				document.all['Name'].value = CertCtl
						.CID_IDCARD_GetName(infoStr);
				document.all['Sex'].value = CertCtl.CID_IDCARD_GetSex(infoStr);
				document.all['Nation'].value = CertCtl
						.CID_IDCARD_GetFolk(infoStr);
				document.all['Born'].value = CertCtl
						.CID_IDCARD_GetBirth(infoStr);
				document.all['Address'].value = CertCtl
						.CID_IDCARD_GetAddr(infoStr);
				document.all['CardNo'].value = CertCtl
						.CID_IDCARD_GetIDNum(infoStr);
				document.all['Police'].value = CertCtl
						.CID_IDCARD_GetDep(infoStr);
				document.all['ActivityLFrom'].value = CertCtl
						.CID_IDCARD_GetBegin(infoStr);
				document.all['ActivityLTo'].value = CertCtl
						.CID_IDCARD_GetEnd(infoStr);
				document.all['FPInfo'].value = CertCtl
						.CID_IDCARD_GetFPInfo(infoStr);
				document.getElementById("imgPre").src = "data:image/bmp;base64,"
						+ CertCtl.CID_IDCARD_ImageDecode(infoStr)
			} else {
				name = pluginobj.CID_IDCARD_GetName(infoStr);
				id = pluginobj.CID_IDCARD_GetIDNum(infoStr);
				document.all['Name'].value = pluginobj
						.CID_IDCARD_GetName(infoStr);
				document.all['Sex'].value = pluginobj
						.CID_IDCARD_GetSex(infoStr);
				document.all['Nation'].value = pluginobj
						.CID_IDCARD_GetFolk(infoStr);
				document.all['Born'].value = pluginobj
						.CID_IDCARD_GetBirth(infoStr);
				document.all['Address'].value = pluginobj
						.CID_IDCARD_GetAddr(infoStr);
				document.all['CardNo'].value = pluginobj
						.CID_IDCARD_GetIDNum(infoStr);
				document.all['Police'].value = pluginobj
						.CID_IDCARD_GetDep(infoStr);
				document.all['ActivityLFrom'].value = pluginobj
						.CID_IDCARD_GetBegin(infoStr);
				document.all['ActivityLTo'].value = pluginobj
						.CID_IDCARD_GetEnd(infoStr);
				document.all['FPInfo'].value = pluginobj
						.CID_IDCARD_GetFPInfo(infoStr);
				document.getElementById("imgPre").src = "data:image/bmp;base64,"
						+ pluginobj.CID_IDCARD_ImageDecode(infoStr)

			}
			window.location.href="id_addAndSelect.action";
		} else {
			alert(infoStr);
		}

	}

	function ReadCardID() { //读物理ID
		clearForm();
		document.all['PhyID'].value = '';
		var IDStr;
		if (isIE()) {
			IDStr = CertCtl.CID_IDCARD_ReadCardID();//读物理ID
		} else {
			document.getElementById('pluginobj').focus();
			IDStr = pluginobj.CID_IDCARD_ReadCardID();//读物理ID
		}
		if (strlen(IDStr) > 5) {
			document.all['PhyID'].value = IDStr;
		} else {
			alert(IDStr);
		}

	}

	function addEvent(name, func)//其他浏览器添加事件
	{
		if (isIE()) {
			CertCtl.focus();
		} else {
			var obj = document.getElementById('pluginobj');
			if (window.addEventListener) {
				obj.addEventListener(name, func, false);
			} else {
				obj.attachEvent(name, func);
			}
		}
	}
</script>
<body onLoad="">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td width="100%" colspan="3">
				<p align="center">
					<b><font color="#5555FF" size="6">CID7000第二代居民身份证网页ActiveX控件<br />测试网页
					</font></b>
			</td>
		</tr>
	</table>
	<p>
		<object id='CertCtl' name='CertCtl' width="0" height="0"
			classid="CLSID:BC044A60-23CC-4F5C-8C16-476648435AC1">
			<embed id="pluginobj" type="application/CID7000id-plugin" width="0"
				height="0">
			</embed>
		</object>
		</script>
	<form id="FReg">
		<table id="TECtrl">
			<tr>
				<td align="right">连接设备：</td>
				<td><input type="Button" id="btnOpen" value="连接设备"
					onclick="Javascript:Connect();"></td>
			</tr>
			<tr>
				<td align="right">读身份证：</td>
				<td><input type="Button" id="btnRdInfo" value="读身份证"
					onclick="Javascript:Readcert();"></td>
			</tr>
			<tr>
				<td align="right">断开设备：</td>
				<td><input type="Button" id="btnClose" value="断开设备"
					onclick="Javascript:Disconnect();"></td>
			</tr>
			<tr>
				<td align="right">读物理ID：</td>
				<td><input type="Button" id="btnGet" value="读物理ID"
					onclick="Javascript:ReadCardID();"></td>
			</tr>
			<tr>
				<td align="right">连接/断开结果：</td>
				<td><input type="text" name="conResult" id="conResult"
					size="49"></td>
			</tr>

			<tr>
				<td align="right">物理ID：</td>
				<td><input type="text" name="PhyID" size="49"></td>
			</tr>

			<tr>
				<td align="right">姓名：</td>
				<td><input type="text" name="Name" size="49">(要求中间，两头都没有空格)</td>
			</tr>

			<tr>
				<td align="right">性别：</td>
				<td><input type="text" name="Sex" size="49">(取值为“1”（表示“男”）或“2”（表示“女”）)</td>
			</tr>

			<tr>
				<td align="right">民族：</td>
				<td><input type="text" name="Nation" size="49"></td>
			</tr>

			<tr>
				<td align="right">出生：</td>
				<td><input type="text" name="Born" size="49">(要求格式为:yyyyMMdd，长度为8)</td>
			</tr>

			<tr>
				<td align="right">地址：</td>
				<td><input type="text" name="Address" size="49"></td>
			</tr>

			<tr>
				<td align="right">身份证号：</td>
				<td><input type="text" name="CardNo" size="49"
					style="color: #FF0000">(居民身份号码，长度18位)</td>
			</tr>

			<tr>
				<td align="right">签发机关：</td>
				<td><input type="text" name="Police" size="49"></td>
			</tr>

			<tr>
				<td align="right">期限起始：</td>
				<td><input type="text" name="ActivityLFrom" size="49">(要求格式为:yyyyMMdd，长度为8)</td>
			</tr>
			<tr>
				<td align="right">期限失效：</td>
				<td><input type="text" name="ActivityLTo" size="49">(要求格式为:yyyyMMdd，长度为8)</td>
			</tr>
			<tr>
				<td align="right">指纹数据：</td>
				<td><input type="text" name="FPInfo" size="49"></td>
			</tr>
			<tr>
				<td align="right">头像：</td>
				<td><img id="imgPre" src=""></td>
			</tr>
		</table>
	</form>
</body>
</html>