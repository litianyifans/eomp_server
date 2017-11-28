var wv_infos = [{
	"url": "indexhome.html",
	"id": "indexhome",
	"head":"<header class='mui-bar mui-bar-nav'style='background:rgba(0,0,0,0.1);'><a class='mui-text-left' style='color:snow;z-index: 1000;'>济南<span class='mui-icon mui-icon-arrowdown'></span></a> <a id='offCanvasBtn' class='mui-pull-right mui-action-menu' style='color:snow;z-index:1000;'><span class='mui-icon mui-icon-bars '></span></a></header>",
	"headstyle":"'color:snow'",
	"styles": {
		"top": "45px",
		"bottom": "50px"
	}
	
}, {
	"url": "imageviewer.html",
	"id": "imageviewer ",
	"head":"<header class='mui-bar mui-bar-nav' style='background-color:white;height:0px;'><h5 class='mui-pull-left' style='font-size:2em;color:black'>心愿单<p style='font-size:15px;text-indent: 1em;padding-top:10px'>您暂无心愿单</p></h5><a class='mui-pull-right'>足迹<span class='mui'></span></a>",
	"headstyle":"'background-color: #C4E3F3;height:0px'</header>",
	"styles": {
		"top": "0px",
		"bottom": "50px"
		
	}
}, {
	"url": "mannger.html",
	"id": "mannger",
	"head":"<header class='mui-bar mui-bar-nav'style='background-color:#FA5D57;'><h1 class='mui-title' style='color: white;'>我的房源</h1>",
	"headstyle":"'background-color:#FA5D57;'</header>",
	"styles": {
		"top": "45px",
		"bottom": "50px"
	}
}, {
	"url":"w.html",
	"id": "w",
	"head":"<header class='mui-bar mui-bar-nav' style='position: relative;'></header>",
	"headstyle":"'position: relative;'",
	"styles": {
		"top": "0px",
		"bottom": "50px"
	}
}];

var childs_wvs = {
	 indexHome : {
		 url: "indexhome.html",
		 id: "indexhome",
		 head:"<header class='mui-bar mui-bar-nav'style='background:rgba(0,0,0,0.1);'><a class='mui-text-left' style='color:snow;z-index: 1000;'>济南<span class='mui-icon mui-icon-arrowdown'></span></a> <a id='offCanvasBtn' class='mui-pull-right mui-action-menu' style='color:snow;z-index:1000;'><span class='mui-icon mui-icon-bars '></span></a></header>",
		 headstyle:"'color:snow'",
		 styles: {
			 top: "45px",
			 bottom: "50px"
		}
	}
}

function swipeToChild(index) {
	var pcv = plus.webview.currentWebview().parent();//获得父窗口
	var v = plus.webview.getWebviewById(wv_infos[index].id);//获得指定id的webview
	var cvs = pcv.children();
	var flag = false;
	for(i = 0; i < cvs.length; i++) {
		if(cvs[i] == v) {
			flag = true;
			v.show();
			pcv.evalJS("tabsActive("+index+")");//执行父窗口中的函数
		} else {
			cvs[i].hide();
		}
	}
	if(!flag) {
		plus.nativeUI.showWaiting();
		setTimeout(function() {
			var temp = plus.webview.create(wv_infos[index].url, wv_infos[index].id, wv_infos[index].styles);
			
			pcv.append(temp);
			temp.show();
			plus.nativeUI.closeWaiting();
			pcv.evalJS("tabsActive("+index+")");
		}, 2000);
	}
}