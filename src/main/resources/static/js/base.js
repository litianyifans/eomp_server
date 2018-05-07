BASE_SERVER_URL="http://112.91.82.56:8086" ;
//BASE_SERVER_URL="http://127.0.0.1:8086" ;
LOGIN_FLAG = false ;
/*mui.plusReady(function(){
     alert("当前页面URL："+plus.webview.currentWebview().getURL());
});*/


function postData(url, data, callback) {
	var token = localStorage.getItem('token') ;
    mui.ajax(BASE_SERVER_URL+url,{  
        data:data,  
        dataType:'json',  
        type:'post',
        headers:{'authToken':token},
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        timeout:60000,  
        success:function(data){
        	if(data.code == 200){
        		callback(data);
        	}else{
        		mui.toast(data.message);
        		mui.openWindow("login.html","login.html");
        	}
        	
        },
        error:function(e){  
            mui.toast("网络异常");
        }  
    });  
} 

function getData(url,callback) {
	var token = localStorage.getItem('token') ;
    mui.ajax(BASE_SERVER_URL+url,{  
        dataType:'json',  
        type:'GET',
        headers:{'authToken':token},
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        timeout:60000,  
        success:function(data){
        	if(data.code == 200){
        		callback(data);
        	}else{
        		mui.openWindow("login.html","login.html");
        		mui.toast(data.message);
        	}
        
        },
        error:function(e){  
            mui.toast("网络异常");
        }  
    });  
}

function getCookie(data) {
   var search = Name + "="//查询检索的值
   var returnvalue = "";//返回值
   if (document.cookie.length > 0) {
     sd = document.cookie.indexOf(search);
     if (sd!= -1) {
        sd += search.length;
        end = document.cookie.indexOf(";", sd);
        if (end == -1)
         end = document.cookie.length;
         //unescape() 函数可对通过 escape() 编码的字符串进行解码。
        returnvalue=unescape(document.cookie.substring(sd, end))
      }
   } 
   return returnvalue;
}

var acookie=document.cookie.split("; ");
function getck(sname)
{//获取单个cookies
for(var i=0;i<acookie.length;i++){
var arr=acookie[i].split("=");
if(sname==arr[0]){
if(arr.length>1)
return unescape(arr[1]);
else
return "";}}
return "";
}


//图片转换成Base64
function getBase64Image(img) {
	var canvas = document.createElement("canvas");
	var width = img.width;
	var height = img.height;
	if(width > height) {
		if(width > 200) {
			height = Math.round(height *= 200 / width);
			width = 200;
		}
	} else {
		if(height > 200) {
			width = Math.round(width *= 200 / height);
			height = 200;
		}
	}
	canvas.width = width;
	canvas.height = height;
	var ctx = canvas.getContext("2d");
	ctx.drawImage(img, 0, 0, width, height);
	var dataURL = canvas.toDataURL("image/png");
	return dataURL.replace("data:image/png;base64,", "");
}			